import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { RentPost } from '../shared/rent-post-model';
import { RentPostService } from '../shared/rent-post.service';

@Component({
  selector: 'app-rent-post.component',
  templateUrl: './rent-post.component.html',
  styleUrls: ['./rent-post.component.css']
})
export class RentPostComponent implements OnInit, OnDestroy {
  rentpost: RentPost[];
  subscription: Subscription;

  constructor(private rentPostService: RentPostService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {

    this.subscription = this.rentPostService.postAdded
      .subscribe(
        (rentPosts: RentPost[]) => {
          this.rentpost = rentPosts;
        }
      );
    this.rentpost = this.rentPostService.getPosts();
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
