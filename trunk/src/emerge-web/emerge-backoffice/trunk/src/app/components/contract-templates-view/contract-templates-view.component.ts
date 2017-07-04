import { Component, OnInit, ViewContainerRef, ViewChild } from '@angular/core';
import { ContractTemplate, ContractTypeEnum } from '../../models/contract-template.model';
import { ContractService }  from '../../services/contract.service';
import { SnackBar } from '../../services/snack-bar.service';
import { TranslateService } from 'ng2-translate/ng2-translate';
import { Utils } from '../../shared/utils';
import { ActivatedRoute  } from '@angular/router';


@Component({
  selector: 'app-contract-templates-view',
  templateUrl: './contract-templates-view.component.html',
  styleUrls: ['./contract-templates-view.component.css']
})
export class ContractTemplatesViewComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private contractService: ContractService,
    private snackBar: SnackBar,
    private viewContainerRef: ViewContainerRef,
    private translate: TranslateService
  ) {
    translate.get(['UPDATE_OK', 'UPDATE_ERROR', 'TOPUP_ERROR', 'TOPUP_OK'
    ]).subscribe(
      result => {
        this.translations = result;
      });
  }
  translations: any = {};
  contractTemplate = new ContractTemplate();
  contractTypeEnum: string[] = Object.keys(ContractTypeEnum);

  getContractTemplate(id: number) {
    this.contractService.getById(id).subscribe(
      response => {
        console.log(response);
      },
      err => {
        console.log(err);
      });
  }


  // findById(id: number) {
  //   this.contractTemplate = this.contractTemplates.filter(item => item.id === id)[0];
  // }

  ngOnInit() {
    this.route.params.subscribe(params => {
      let id = Number.parseInt(params['id']);
      this.getContractTemplate(id);
    });
  }

}
