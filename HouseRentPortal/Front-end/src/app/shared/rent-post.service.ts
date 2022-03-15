import { Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject';


import { RentPost } from './rent-post-model';
import { RentRequest } from './rent-request-model';

@Injectable()
export class RentPostService {
  postAdded = new Subject<RentPost[]>();

  private rentPost: RentPost[] = [
    new RentPost(101,435,'Kodambakam', 'Chennai',1200,'2-BHK',11400),
    new RentPost(102,563,'Guindy', 'Chennai',800,'1-BHK',10250),
    new RentPost(103,883,'K.K Nagar', 'Trichy',650,'1-BHK',7500)
  ];

  private rentRequest: RentRequest[] = [
    new RentRequest(101,'Kodambakam', 'Chennai','Sathish Kumar','985745855',''),
    new RentRequest(102,'Guindy', 'Chennai','Sathish Kumar','985745855',''),
    new RentRequest(105,'Meenapakam', 'Chennai','Raja','754855855','Approved'),
    new RentRequest(101,'Kodambakam', 'Chennai','Vinoth Kumar','8596985654',''),
    new RentRequest(102,'Guindy', 'Chennai','Vimal raj','8965874585','')
  ];

  constructor() {}

  getPosts() {
    return this.rentPost.slice();
  }

  getPost(index: number) {
    return this.rentPost[index];
  }

  getRequests() {
    return this.rentRequest.slice();
  }
  
  addPost(rentpost: RentPost) {
      this.rentPost.push(rentpost);
      this.postAdded.next(this.rentPost.slice());
  }

  // addRecipe(recipe: Recipe) {
  //   this.recipes.push(recipe);
  //   this.recipesChanged.next(this.recipes.slice());
  // }

  // updateRecipe(index: number, newRecipe: Recipe) {
  //   this.recipes[index] = newRecipe;
  //   this.recipesChanged.next(this.recipes.slice());
  // }

  // deleteRecipe(index: number) {
  //   this.recipes.splice(index, 1);
  //   this.recipesChanged.next(this.recipes.slice());
  // }
}
