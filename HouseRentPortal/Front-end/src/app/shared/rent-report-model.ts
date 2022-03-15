export class RentReport {
  constructor(public ownerId: number,public propId: number, public locality :string,public city :string, public type :string,
              public requestedBy: string, public price: number, public approvalStatus : string) {}
}
