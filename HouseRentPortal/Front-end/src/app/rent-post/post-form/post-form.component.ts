import { Component, OnInit } from '@angular/core';
import { RentPostService } from 'src/app/shared/rent-post.service';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RentPost } from 'src/app/shared/rent-post-model';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent implements OnInit {

  postForm: FormGroup;
  public rentpost :RentPost;

  constructor(private rentPostService: RentPostService
                  ,private route: ActivatedRoute
                  ,private router: Router ){
  }

  ngOnInit() {
    this.initForm();
  }

  onSubmit() {
    console.log(this.postForm.value);
      this.rentpost  = new RentPost(104,3243,this.postForm.get('locality').value,
                                this.postForm.get('city').value,this.postForm.get('sqFeet').value,
                                this.postForm.get('type').value,this.postForm.get('price').value
                              );
      console.log(this.rentpost);
      this.rentPostService.addPost(this.rentpost);
      this.clearForm();
  }

  clearForm(){
    this.initForm();
  }

  onReset() {
    alert('Form Will be Reset!');
    this.clearForm();
  }

  private initForm() {
    let locality = '';
    let city = '';
    let sqFeet = '';
    let price = '';
    let type = '';

    

    this.postForm = new FormGroup({
      'locality': new FormControl(locality, Validators.required),
      'city': new FormControl(city, Validators.required),
      'sqFeet': new FormControl(sqFeet, [Validators.required,Validators.pattern(/^[1-9]+[0-9]*$/)]),
      'type': new FormControl(type, Validators.required),
      'price': new FormControl(price, [Validators.required,Validators.pattern(/^[1-9]+[0-9]*$/)])
    });
  }


}
