import { Component, OnInit, ViewContainerRef, ViewChild } from '@angular/core';
import { ContractTemplate, ContractTypeEnum } from '../../models/contract-template.model';
import { ContractService }  from '../../services/contract.service';
import { SnackBar } from '../../services/snack-bar.service';
import { TranslateService } from 'ng2-translate/ng2-translate';


@Component({
  selector: 'app-contract-template-create',
  templateUrl: './contract-template-create.component.html',
  styleUrls: ['./contract-template-create.component.css'],
})

export class ContractTemplateCreateComponent implements OnInit {

  contractTemplate = new ContractTemplate();
  translations: any = {};
  constructor(
    private contractService: ContractService,
    private snackBar: SnackBar,
    private viewContainerRef: ViewContainerRef,
    private translate: TranslateService) {
    translate.get(['CREATE_OK', 'CREATE_ERROR']).subscribe(
      result => {
        this.translations = result;
      });
  }

  contractTypeEnum: string[] = Object.keys(ContractTypeEnum);

  isLoading: boolean = false;

  clear() {
    this.contractTemplate = new ContractTemplate();
  }

  create() {
    this.isLoading = true;
    this.contractService.create(this.contractTemplate).subscribe(
      success => {
        console.log(success);
        this.snackBar.open(this.translations.CREATE_OK, this.viewContainerRef);
        this.isLoading = false;
        //this.router.navigate(['/backoffice/contract-templates/view/', success.contractTemplateId]);
      },
      err => {
        this.isLoading = false;
        this.snackBar.open(this.translations.CREATE_ERROR, this.viewContainerRef);
      });
  }

  ngOnInit() {
  }

}
