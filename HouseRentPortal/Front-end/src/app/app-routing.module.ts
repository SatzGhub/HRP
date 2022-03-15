import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { RentPostComponent } from './rent-post/rent-post.component';
import { PostFormComponent } from './rent-post/post-form/post-form.component';
import { PostComponent } from './rent-post/post/post.component';
import { RentRquestsComponent } from './rent-rquests/rent-rquests.component';
import { ReportComponent } from './report/report.component';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login',  component: LoginComponent },
  { path: 'posts', component: RentPostComponent
   //, children: [
   //  { path: '', component: PostFormComponent }
    //  { path: '', component: PostComponent }
   //] 
  },
  { path: 'requests', component: RentRquestsComponent },
  { path: 'reports', component: ReportComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
