export class RentRequest {
  constructor(public propId: number, public locality :string,public city :string, 
              public requestedBy: string, public contact :string, public approval : string) {}
}
