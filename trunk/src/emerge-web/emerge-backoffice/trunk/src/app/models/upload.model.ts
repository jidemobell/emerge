export enum BankEnum {
  SOL = <any>'SOL',
  BFA = <any>'BFA',
  BAI = <any>'BAI',
  MILLENIUM = <any>'MILLENIUM',
  BIC = <any>'BIC',
  ATLANTICO = <any>'ATLANTICO'
}

export class Upload {
  public id: number;
  public bankName: string;
  public statementFile: any;
  public fileName: string;
  constructor() { }
}
