import { Component, OnInit, ViewContainerRef, ViewChild } from '@angular/core';
import { ContractTemplate } from '../../models/contract-template.model';
import { ContractService }  from '../../services/contract.service';
import { SnackBar } from '../../services/snack-bar.service';
import { TranslateService } from 'ng2-translate/ng2-translate';
import { Utils } from '../../shared/utils';


@Component({
  selector: 'app-contract-templates',
  templateUrl: './contract-templates.component.html',
  styleUrls: ['./contract-templates.component.css']
})
export class ContractTemplatesComponent implements OnInit {

  contractTemplate = new ContractTemplate();
  searchResult: any = {
    data: []
  };
  isSearchVisible: boolean = true;
  query: any = {};
  translations: any = {};
  isLoading: boolean = false;
  constructor(
    private contractService: ContractService,
    private snackBar: SnackBar,
    private viewContainerRef: ViewContainerRef,
    private translate: TranslateService) {
    translate.get(['ID', 'NAME', 'STATUS', 'FISCAL_NUMBER', 'COUNTRY',
      'TAGS', 'DELETE_OK', 'DELETE_ERROR', 'SEARCH_ERROR']).subscribe(
      result => {
        this.translations = result;
      });
  }
  ngOnInit() {
  }

  search() {
    this.query = Utils.searchFilter(this.query);
    this.isLoading = true;
    this.contractService.all(this.query).subscribe(
      response => {
        this.searchResult = response;
        this.isLoading = false;
      },
      err => {
        this.snackBar.open(this.translations.SEARCH_ERROR, this.viewContainerRef);
        this.isLoading = false;
      });
  }

  clear() {
    this.query = {};
  }

}
