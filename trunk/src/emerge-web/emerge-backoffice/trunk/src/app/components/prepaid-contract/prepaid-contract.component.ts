import { Component, ViewContainerRef, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContractPrepaid } from '../../models/contract-prepaid.model';
import { ContractService } from '../../services/contract.service';
import { PrepaidService } from '../../services/prepaid.service';
import { ServicePrepaid } from '../../models/prepaid.model';
import { SnackBar } from '../../services/snack-bar.service';
import { TranslateService } from 'ng2-translate/ng2-translate';

@Component({
  selector: 'app-prepaid-contract',
  templateUrl: './prepaid-contract.component.html',
  styleUrls: ['./prepaid-contract.component.css'],
  providers: [PrepaidService, ContractService]
})
export class PrepaidContractComponent implements OnInit {

  sub: any;
  translations: any = {};
  prepaidContract = new ContractPrepaid();
  service: any = {
    serviceType: '',
    servicePrepaidId: 0
  };
  prepaidData: PrepaidService[] = []
  isLoading: boolean = false;


  constructor(
    public route: ActivatedRoute,
    public router: Router,
    private prepaidService: PrepaidService,
    private contractService: ContractService,
    private translate: TranslateService,
    private snackBar: SnackBar,
    private viewContainerRef: ViewContainerRef
  ) {
    translate.get(['CREATE_OK',
      'CREATE_ERROR',
      'UPDATE_OK',
      'UPDATE_ERROR',
      'CANCEL_OK',
      'CANCEL_ERROR'
    ]).subscribe(
      result => {
        this.translations = result;
      });
  }
  contractId: number;
  customerId: number;
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      if (params['customerId'] && params['contractId']) {
        this.customerId = Number.parseInt(params['customerId']);
        this.contractId = Number.parseInt(params['contractId']);
      }
    });
    this.getPrepaidServices();
  }

  query = {
    status: 'READY'
  }

  getPrepaidServices() {
    this.prepaidService.all(this.query).subscribe(
      response => {
        this.prepaidData = response.data;
      },
      err => {
        console.log(err);
      });
  }

  update() {
    this.prepaidContract.customerId = this.customerId;
    this.prepaidContract.servicePrepaid = this.service.servicePrepaidId;
    this.prepaidContract.serviceType = this.service.serviceType;
    this.prepaidContract.startDate = new Date();
    this.prepaidContract.statusDate = new Date();
    this.isLoading = true;
    this.contractService.updatePrepaidContract(this.contractId, this.prepaidContract).subscribe(
      response => {
        this.isLoading = false;
        this.snackBar.open(this.translations.UPDATE_OK, this.viewContainerRef);
      },
      err => {
        this.snackBar.open(this.translations.UPDATE_ERROR, this.viewContainerRef);
        this.isLoading = false;
        console.log(err);
      });
  }

  clear() {
    this.prepaidContract = new ContractPrepaid();
    this.service.serviceType = null;
    this.service.servicePrepaidId = null;
  }

  cancel() {
    this.router.navigate(['/backoffice/customers/' + this.customerId
      + '/prepaid-contract/create']);
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
