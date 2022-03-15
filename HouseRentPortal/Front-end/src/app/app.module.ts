import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { DropdownDirective } from './shared/dropdown.directive';
import { AppRoutingModule } from './app-routing.module';

import { RentPostComponent } from './rent-post/rent-post.component';
import { PostComponent } from './rent-post/post/post.component';
import { PostFormComponent } from './rent-post/post-form/post-form.component';
import { RentPostService } from './shared/rent-post.service';
import { RentRquestsComponent } from './rent-rquests/rent-rquests.component';
import { RentRequestService } from './shared/rent-request.service';
import { ReportComponent } from './report/report.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DropdownDirective,
    RentPostComponent,
    PostComponent,
    PostFormComponent,
    RentRquestsComponent,
    ReportComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [RentPostService,RentRequestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
