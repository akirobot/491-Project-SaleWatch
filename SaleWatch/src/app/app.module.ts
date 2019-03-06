import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { ChartsModule } from 'ng2-charts';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/account/components/login/login.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { NavigationBarLowerComponent } from './components/navigation-bar-lower/navigation-bar-lower.component';
import { FaqComponent } from './components/faq/faq.component';
import { DeveloperGuideComponent } from './components/developer-guide/developer-guide.component';
import { UserGuideComponent } from './components/user-guide/user-guide.component';
import { GameLibraryComponent } from './components/game-library/game-library.component';
import { RegisterComponent } from './components/account/components/register/register.component';
import { GameSearchComponent } from './components/home-page/components/game-search/game-search.component';
import { GameSearchResultsComponent } from './components/home-page/components/game-search/components/game-search-results/game-search-results.component';
import { GameDataComponent } from './components/home-page/components/game-search/components/game-data/game-data.component';
import { ChartLineComponent } from './components/chart-line/chart-line.component';
import { ChartBarComponent } from './components/chart-bar/chart-bar.component';
import { ChartDoughnutComponent } from './components/chart-doughnut/chart-doughnut.component';
import { ChartRadarComponent } from './components/chart-radar/chart-radar.component';
import { ChartPieComponent } from './components/chart-pie/chart-pie.component';
import { ChartPolarComponent } from './components/chart-polar/chart-polar.component';
import { ChartDynamicComponent } from './components/chart-dynamic/chart-dynamic.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationBarComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    LoginComponent,
    AboutUsComponent,
    NavigationBarLowerComponent,
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
    ChartDynamicComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
