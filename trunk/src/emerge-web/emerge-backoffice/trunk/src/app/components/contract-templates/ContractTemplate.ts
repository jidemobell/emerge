export class ContractTemplate {
  public templatestatus: string;
  public statusdate:Date;
  public description:string;
  public contractname:string;
  public modificationdate: Date;
  public secondcontractor:string;
  public preamble:string;
  public scope:string;
  public customerobligations:string;
  public supplierobligations:string;
  public financialterms:string;
  public additionalclauses:string;
  public termsandtermination:string;
  public intellectualpropertyrights:string;
  public returnofproperty:string;
  public confidentialty:string;
  public governinglaw:string;
  public service:string;

  clear() {
     this.templatestatus = '';
     this.contractname = '';
  }
}
