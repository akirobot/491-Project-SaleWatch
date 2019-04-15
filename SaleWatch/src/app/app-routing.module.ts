import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/account/components/login/login.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { FaqComponent } from './components/faq/faq.component';
import { DeveloperGuideComponent } from './components/developer-guide/developer-guide.component';
import { UserGuideComponent } from './components/user-guide/user-guide.component';
import { GameLibraryComponent } from './components/game-library/game-library.component';
import { RegisterComponent } from './components/account/components/register/register.component';
import { GameSearchComponent } from './components/home-page/components/game-search/game-search.component';
import { GameSearchResultsComponent } from './components/home-page/components/game-search/components/game-search-results/game-search-results.component';
import { GameDataComponent } from './components/home-page/components/game-search/components/game-data/game-data.component';
import { ChartBarComponent } from './components/charts/chart-bar/chart-bar.component';
import { ChartDoughnutComponent } from './components/charts/chart-doughnut/chart-doughnut.component';
import { ChartDynamicComponent } from './components/charts/chart-dynamic/chart-dynamic.component';
import { ChartLineComponent } from './components/charts/chart-line/chart-line.component';
import { ChartPieComponent } from './components/charts/chart-pie/chart-pie.component';
import { ChartPolarComponent } from './components/charts/chart-polar/chart-polar.component';
import { ChartRadarComponent } from './components/charts/chart-radar/chart-radar.component';
import { ProfileComponent } from './components/account/components/profile/profile.component';
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
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'about-us',
    component: AboutUsComponent
  },
  {
    path: 'faq',
    component: FaqComponent
  },
  {
    path: 'developer-guide',
    component: DeveloperGuideComponent
  },
  {
    path: 'user-guide',
    component: UserGuideComponent
  },
  {
    path: 'game-library',
    component: GameLibraryComponent
  },
  {
    path: 'game-search-results',
    component: GameSearchComponent,
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: GameSearchResultsComponent
      },
      {
        path: 'game-data',
        component: GameDataComponent
      }
    ]
  },
  {
    path:'chart-bar',
    component: ChartBarComponent
  },
  {
    path:'chart-doughnut',
    component: ChartDoughnutComponent
  },
  {
    path:'chart-dynamic',
    component: ChartDynamicComponent
  },
  {
    path:'chart-line',
    component: ChartLineComponent
  },
  {
    path:'chart-pie',
    component: ChartPieComponent
  },
  {
    path:'chart-polar',
    component: ChartPolarComponent
  },
  {
    path:'chart-radar',
    component: ChartRadarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
