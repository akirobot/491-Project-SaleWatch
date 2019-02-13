import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/account/components/login/login.component';
import { WishlistComponent} from './components/account/components/wishlist/wishlist.component';
import { AnalyticsComponent} from './components/analytics/analytics.component';



const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: HomePageComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'wishlist',
    component: WishlistComponent
  },
  {
    path: 'analytics',
    component: AnalyticsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
