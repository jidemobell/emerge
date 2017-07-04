import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { HttpClient } from '../shared/http-client';
import { config } from '../shared/config';
import { Customer } from './../models/customer.model';
import { ContractPrepaid } from '../models/contract-prepaid.model';
import { ContractTemplate } from '../models/contract-template.model';
import { ContractPostpaid } from './../models/contract-postpaid.model';


@Injectable()
export class ContractService {

  constructor(private httpService: HttpClient) { }

  handleError(error: any) {
    let errorMsg = JSON.parse(error._body);
    console.error(errorMsg);
    return Observable.throw(errorMsg.message || errorMsg.type);
  }

  create(contractTemplate: ContractTemplate)
    : Observable<ContractTemplate> {
    return this.httpService.post(`${config.url.bssPo}contract-templates/`,
      contractTemplate)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error ||
        'Server error'));
  }

  getByName(templateName: string): Observable<ContractTemplate> {
    const url = `${config.url.bssPo}contract-
    templates?template_name=${templateName}`;
    return this.httpService.get(url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }

  getById(id: number): Observable<ContractTemplate> {
    const url = `${config.url.bssPo}contract-templates/${id}`;
    return this.httpService.get(url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }

  update(id: number, contractTemplate: ContractTemplate)
    : Observable<ContractTemplate> {
    const url = `${config.url.bssPo}contract-templates/${id}`;
    return this.httpService.put(url, contractTemplate)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }


  all(search: Object = {}): Observable<Array<ContractTemplate>> {
    return this.httpService.get(`${config.url.bssPo}contract-templates/`, search)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }

  delete(id: number): Observable<ContractTemplate> {
    return this.httpService.delete(`${config.url.bssPo}
      contract-templates/${id}}`)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }


  //Prepaid Contract for Customer
  createPrepaidContract(customerId: number, prepaid: ContractPrepaid)
    : Observable<ContractPrepaid> {
    const url = `${config.url.bssPo}customers/${customerId}/prepaid-contracts`;
    return this.httpService.post(url, prepaid)
      .map((res: Response) => res.json())
      .catch(this.handleError);
  }

  getAllCustomerPrepaidContract(customerId: number) {
    return this.httpService.get(`${config.url.bssPo}customers/` +
      `${customerId}/prepaid-contracts`)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error ||
        'Server error'));
  }

  confirmPrepaidContract(customerId: number, contractId: number) {
    const url = `${config.url.bssPo}customers/${customerId}/` +
      `prepaid-contracts/${contractId}/confirm`;
    return this.httpService.put(url, {})
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error ||
        'Server error'));
  }


  updatePrepaidContract(contractId, prepaid: ContractPrepaid)
    : Observable<ContractPrepaid> {
    const url = `${config.url.bssPo}customers/${prepaid.customerId}` +
      `/prepaid-contracts/${contractId}`;
    return this.httpService.put(url, prepaid)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }

  getPrepaidContract(customerId: number,
    contractId: number): Observable<ContractPrepaid> {
    const url = `${config.url.bssPo}customers/${customerId}
    /prepaid-contracts/${contractId}`;
    return this.httpService.get(url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }

  closePrepaidContract(customerId: number,
    contractId: number, serviceId: number): Observable<ContractPrepaid> {
    const url = `${config.url.bssPo}customers/${customerId}/` +
      `prepaid-contracts/${contractId}/services/${serviceId}/cancel`;
    return this.httpService.put(url, {})
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }


  createPostpaidContract(customerId: number,
    postpaid: ContractPostpaid): Observable<ContractPostpaid> {
    const url = `${config.url.bssPo}customers/${customerId}/postpaid-contracts`;
    return this.httpService.post(url, { postpaid })
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  confirmPostpaidContractByCustomerAndContract(customerId: number,
    contractId: number, postpaid: ContractPostpaid): Observable<ContractPostpaid> {
    const url = `${config.url.bssPo}customers/${customerId}
    /postpaid-contracts/${contractId}/confirm`;
    return this.httpService.put(url, { postpaid })
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }

  getPostpaidContractByCustomer(customerId: number): Observable<ContractPostpaid> {
    const url = `${config.url.bssPo}customers/${customerId}/postpaid-contracts`;
    return this.httpService.get(url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }

  updatePostpaidContractByCustomerAndContract(customerId: number,
    contractId: number, postpaid: ContractPostpaid): Observable<ContractPostpaid> {
    const url = `${config.url.bssPo}customers/${customerId}
    /postpaid-contracts/${contractId}`;
    return this.httpService.put(url, { postpaid })
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }

  deletePostpaidContractByCustomerAndContract(customerId: number,
    contractId: number): Observable<ContractPostpaid> {
    const url = `${config.url.bssPo}customers/${customerId}
    /postpaid-contracts/${contractId}`;
    return this.httpService.delete(url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error
        || 'Server error'));
  }

}
