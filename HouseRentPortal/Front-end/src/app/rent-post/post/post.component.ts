import { Component, OnInit } from '@angular/core';
import { RentPost } from 'src/app/shared/rent-post-model';
import { RentPostService } from 'src/app/shared/rent-post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  public rentPost : RentPost[];

  constructor(private rentPostService: RentPostService) { }

  ngOnInit(): void {
    this.fetchPosts();
  }

  fetchPosts() {
    this.rentPost = this.rentPostService.getPosts();
  }

}
