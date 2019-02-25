import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

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
    GameDataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
