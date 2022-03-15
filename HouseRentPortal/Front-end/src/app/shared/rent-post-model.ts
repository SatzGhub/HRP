export class RentPost {
  constructor(public propId: number, public ownerId :number,public locality :string,public city :string, 
              public sqFeet: number, public type :string, public price : number) {}
}
