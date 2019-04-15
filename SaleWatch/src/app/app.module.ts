import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ChartsModule } from 'ng2-charts';

import { UserService } from './services/user.service';
import { GameService } from './services/game.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
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
import { ChartLineComponent } from './components/charts/chart-line/chart-line.component';
import { ChartBarComponent } from './components/charts/chart-bar/chart-bar.component';
import { ChartDoughnutComponent } from './components/charts/chart-doughnut/chart-doughnut.component';
import { ChartRadarComponent } from './components/charts/chart-radar/chart-radar.component';
import { ChartPieComponent } from './components/charts/chart-pie/chart-pie.component';
import { ChartPolarComponent } from './components/charts/chart-polar/chart-polar.component';
import { ChartDynamicComponent } from './components/charts/chart-dynamic/chart-dynamic.component';
import { ProfileComponent } from './components/account/components/profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationBarComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    LoginComponent,
    AboutUsComponent,
    FaqComponent,
    DeveloperGuideComponent,
    UserGuideComponent,
    GameLibraryComponent,
    RegisterComponent,
    GameSearchComponent,
    GameSearchResultsComponent,
    GameDataComponent,
    ChartLineComponent,
    ChartBarComponent,
    ChartDoughnutComponent,
    ChartRadarComponent,
    ChartPieComponent,
    ChartPolarComponent,
    ChartDynamicComponent,
    ProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ChartsModule
  ],
  providers: [
    UserService,
    GameService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
