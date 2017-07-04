import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Router } from '@angular/router';
import { CountryService } from '../../services/country.service';
import { CustomerService } from '../../services/customer.service';
import { Customer } from '../../models/customer.model';
import { CustomerAddress } from '../../models/customer-address.model';
import { Contact } from '../../models/contact.model';
import { Country } from '../../models/country.model';
import { SnackBar } from '../../services/snack-bar.service';
import { TranslateService } from 'ng2-translate/ng2-translate';
import { Utils } from '../../shared/utils';


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})

export class CustomerCreateComponent implements OnInit {
  public customer = new Customer();
  formSubmitted = false;
  visible: boolean = true;
  tags: string[] = [];
  isLoading: boolean = true;
  taxExemptionCertificates: string[] = [];
  message: string = '';
  countries: Country[] = [];
  contact = new Contact();
  translations: any = {};
  fiscalNumberRegExp: RegExp = Utils.regexp.fiscalNumber;
  phoneRegExp: RegExp = Utils.regexp.phone;
  $error: boolean = false;

  constructor(private customerService: CustomerService,
    private countryService: CountryService,
    private router: Router,
    private snackBar: SnackBar,
    private viewContainerRef: ViewContainerRef,
    translate: TranslateService) {
    translate.get(['CREATE_OK', 'CREATE_ERROR']).subscribe(
      result => {
        this.translations = result;
      });
  }

  hasError(regexp: RegExp, value: string) {
    
  }

  create() {
    this.formSubmitted = true;
    this.isLoading = true;
    this.customer.tags = this.customerService.getTagString(this.tags);
    this.customer.taxExemptionCertificates =
      this.customerService.getTagString(this.taxExemptionCertificates);
    this.customerService.create(this.customer).subscribe(
      customer => {
        this.isLoading = false;
        this.snackBar.open(this.translations.CREATE_OK, this.viewContainerRef);
        this.router.navigate(['/backoffice/customers', customer.id]);
      },
      err => {
        this.snackBar.open(this.translations.CREATE_ERROR,
          this.viewContainerRef);
      }
    );
  }

  addAddress() {
    this.customer.customerAddresses.push(new CustomerAddress());
  }

  removeAddress(addressIndex: number) {
    this.customer.customerAddresses.splice(addressIndex, 1);
  }

  removeContact(addressIndex: number, contactIndex: number) {
    this.customer.customerAddresses[addressIndex].contacts.splice(contactIndex, 1);
  }

  addContact(index: number) {
    this.customer.customerAddresses[index].contacts.push(new Contact());
  }

  cancelCustomer() {
    this.customer = new Customer();
    this.addAddress();
    this.addContact(0);
    this.tags = [];
    this.taxExemptionCertificates = [];
    this.resetSubmitState();
  }

  resetSubmitState() {
    this.formSubmitted = false;
  }

  setFormName(i, j): string {
    return `.${i}.${j}`;
  }

  getCountries() {
    this.countryService.all().subscribe(
      countries => {
        this.countries = countries;
      },
      err => {
        this.countries = [{
          name: 'Nigeria',
          code: 'NG'
        }];
      }
    )
  }

  ngOnInit() {
    this.getCountries();
    this.addAddress();
    this.addContact(0);
  }
}
