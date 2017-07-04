import { Component, OnInit, ViewContainerRef, ViewChild  } from '@angular/core';
import { Customer, StatusEnum } from '../../models/customer.model';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { CustomerService } from '../../services/customer.service';
import { SnackBar } from '../../services/snack-bar.service';
import { CountryService } from '../../services/country.service';
import { CustomerAddress } from '../../models/customer-address.model';
import { Contact } from '../../models/contact.model';
import { Utils } from '../../shared/utils';
import { ConfirmDialog } from '../custom/confirm-dialog/confirm-dialog.component';
import { TranslateService } from 'ng2-translate/ng2-translate';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
  entryComponents: [ConfirmDialog]
})
export class CustomerComponent implements OnInit {
  @ViewChild('confirmDialog') confirmDialog;
  public customer = new Customer();
  addresses: CustomerAddress[] = [];
  translations: any = {};
  currentAddress: CustomerAddress;
  currentAddressIndex: number = 0;
  tags: string[] = [];
  taxExemptionCertificates: string[] = [];
  message: string;
  count: number = 0;
  isLoading: boolean = false;
  countries: any = {};
  statusEnum: string[] = Object.keys(StatusEnum);
  fiscalNumberRegExp: RegExp = Utils.regexp.fiscalNumber;
  emailRegExp: RegExp = Utils.regexp.email;
  phoneRegExp: RegExp = Utils.regexp.phone;

  constructor(private route: ActivatedRoute, private router: Router,
    private customerService: CustomerService,
    private snackBar: SnackBar,
    private countryService: CountryService,
    private viewContainerRef: ViewContainerRef,
    private translate: TranslateService) {
    translate.get(['UPDATE_OK', 'UPDATE_ERROR', 'DELETE_ERROR', 'DELETE_OK',
      'CREATE_OK', 'CREATE_ERROR']).subscribe(result => {
        this.translations = result;
      });
  }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.getCustomer(+params['id']);
    });

    this.countryService.all().subscribe(
      countries => {
        this.countries = this.countryService.getAsObject(countries);
      }
    )
  }

  responseData: any = {
    message: ''
  };

  getCustomer(id: number) {
    this.isLoading = true;
    this.customerService.get(id).subscribe(
      response => {
        this.customer = response;
        this.tags = this.customerService.getTagArray(response.tags);
        this.taxExemptionCertificates =
          this.customerService.getTagArray(response.taxExemptionCertificates);
        this.getBillingAddress(this.customer.id);
        this.isLoading = false;
      },
      err => {
        this.customer = null;
        this.isLoading = false;
      });
  }

  updateCustomer() {
    this.isLoading = true;
    this.customer.tags = this.customerService.getTagString(this.tags);
    this.customer.taxExemptionCertificates =
      this.customerService.getTagString(this.taxExemptionCertificates);
    this.customerService.update(this.customer).subscribe(
      response => {
        this.isLoading = false;
        this.snackBar.open(this.translations.UPDATE_OK, this.viewContainerRef);
      },
      err => {
        this.isLoading = false;
        this.snackBar.open(this.translations.UPDATE_ERROR,
          this.viewContainerRef);
      });
  }

  delete(id: number) {
    this.confirmDialog.open(null, ok => {
      if (ok) {
        this.customerService.delete(id).subscribe(
          response => {
            this.snackBar.open(this.translations.DELETE_OK,
              this.viewContainerRef);
            this.router.navigate(['/backoffice/customers']);
          },
          err => {
            this.snackBar.open(this.translations.DELETE_ERROR,
              this.viewContainerRef);
          });
      }
    });
  }


  getBillingAddress(id: number) {
    this.customerService.getAddresses(id).subscribe(
      response => {
        this.addresses = response.data as CustomerAddress[];
        for (let address of this.addresses) {
          address.id = address.id || address.customerAddressId;
          this.getContacts(id, address);
        }
      },
      err => {
        console.log(err);
      });
  }

  getButtonElement($event) {
    if ($event && $event.target && $event.target.parentElement) {
      return $event.target.parentElement.parentElement;
    }

    return {};
  }

  validateAddress(address: CustomerAddress) {
      return address['$error'] || !address.email || !address.address ||
      !address.addressName || !address.telephoneNumber;
  }

  validateContact(contact: Contact) {
      return contact['$error'] || !contact.contactType ||
      !contact.contactName || !contact.contactEmail || !contact.contactPhone;
  }

  saveAddress(customerId: number, address: CustomerAddress, $event) {
    const elem = this.getButtonElement($event);
    elem.disabled = true;
    if (address.id) {
      this.updateAddress(address.id, address, _ => elem.disabled = false);
    } else {
      this.customerService.createAddress(address, customerId)
        .subscribe(response => {
          elem.disabled = false;
          address.customerAddressId = response.id;
          address.id = response.id || address.customerAddressId;
          this.snackBar.open(this.translations.CREATE_OK,
            this.viewContainerRef);
        },
        err => {
          elem.disabled = false;
          this.snackBar.open(this.translations.CREATE_ERROR,
            this.viewContainerRef);
        });
    }
  }

  updateAddress(addressId: number, address: CustomerAddress, cb?: Function) {
    this.customerService.updateAddress(this.customer.id, addressId, address)
      .subscribe(response => {
        if (cb) {
          cb();
        }

        this.snackBar.open(this.translations.UPDATE_OK, this.viewContainerRef);
      }, err => {
        if (cb) {
          cb();
        }

        this.snackBar.open(this.translations.UPDATE_ERROR,
          this.viewContainerRef);
      });
  }

  getContacts(customerId: number, address: CustomerAddress) {
    this.customerService.getContacts(customerId, address.id).subscribe(
      contacts => {
        address.contacts = contacts as Contact[];
      },
      err => {
        console.log(err);
      });
  }

  setFormName(i, j): string {
    return `.${i}.${j}`;
  }

  saveContact(customerId: number, contact: Contact, addressId: number,
    $event) {

    if (!addressId) {
      return;
    }
    const elem = this.getButtonElement($event);
    elem.disabled = true;
    if (contact.id) {
      this.updateContact(addressId, contact, _ => elem.disabled = false);
    } else {
      contact.billingAddressId = addressId;
      elem.disabled = true;
      this.customerService.createContact(contact, customerId, addressId)
        .subscribe(response => {
          contact.id = response.id;
          elem.disabled = false
          this.snackBar.open(this.translations.CREATE_OK,
            this.viewContainerRef);
        },
        err => {
          elem.disabled = false
          this.snackBar.open(this.translations.CREATE_ERROR,
            this.viewContainerRef);
        });
    }
  }

  updateContact(addressId: number, contact: Contact, cb?: Function) {
    this.customerService.updateContact(this.customer.id, addressId, contact)
      .subscribe(response => {
        console.log('update', response);
        if (cb) {
          cb();
        }
        this.snackBar.open(this.translations.UPDATE_OK, this.viewContainerRef);
      }, err => {
        console.log(err);
        if (cb) {
          cb();
        }
        this.snackBar.open(this.translations.UPDATE_ERROR,
          this.viewContainerRef);
      });
  }

  addAddress() {
    this.addresses.push(new CustomerAddress());
  }

  removeAddress(addressId: number, addressIndex: number, $event) {
    const elem = this.getButtonElement($event);
    elem.disabled = true;
    this.confirmDialog.open(null, ok => {
      if (ok) {
        if (addressId) {
          this.customerService.deleteAddress(this.customer.id, addressId)
            .subscribe(response => {
              elem.disabled = false;
              this.snackBar.open(this.translations.DELETE_OK,
                this.viewContainerRef);
              this.addresses.splice(addressIndex, 1);
            },
            err => {
              elem.disabled = false;
              this.snackBar.open(this.translations.DELETE_ERROR,
                this.viewContainerRef);
            });
        } else {
          elem.disabled = false;
          this.addresses.splice(addressIndex, 1);
        }
      } else {
        elem.disabled = false;
      }
    });
  }

  addContact(index: number, address: CustomerAddress) {
    let contact = new Contact();
    contact.billingAddressId = address.id;
    address.contacts.push(contact);
  }

  removeContact(index: number, contactId: number, address: CustomerAddress,
    $event) {

    const elem = this.getButtonElement($event);
    elem.disabled = false;
    this.confirmDialog.open(null, ok => {
      if (ok) {
        if (contactId) {
          this.customerService.deleteContact(this.customer.id, address.id,
            contactId).subscribe(
            response => {
              this.snackBar.open(this.translations.DELETE_OK,
                this.viewContainerRef);

              address.contacts.splice(index, 1);
            },
            err => {
              this.snackBar.open(this.translations.DELETE_ERROR,
                this.viewContainerRef);
            });

        } else {
          address.contacts.splice(index, 1);
        }
      }
    });
  }

  cancelForm() {
    this.router.navigate(['/backoffice/customers']);
  }
}
