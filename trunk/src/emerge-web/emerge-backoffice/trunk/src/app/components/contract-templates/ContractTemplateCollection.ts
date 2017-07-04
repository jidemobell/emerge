import { ContractTemplate } from './ContractTemplate';

export class contractCollection {

  private contractModel: ContractTemplate[] = [];
  constructor() {}

  getbyContractName(name:string)
  {
    return this.contractModel.filter(u=> u.contractName = name).pop();
  }

  getDescription(description:string)
  {
    return this.contractModel.filter(u=> u.description = description).pop();
  }
}
