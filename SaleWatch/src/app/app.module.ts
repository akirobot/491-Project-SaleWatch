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
import { GamesComponent } from './components/account/components/games/games.component';
import { WishlistComponent } from './components/account/components/wishlist/wishlist.component';
import { WatchlistComponent } from './components/account/components/watchlist/watchlist.component';
import { FriendslistComponent } from './components/account/components/friendslist/friendslist.component';
import { ProfileComponent } from './components/account/components/profile/profile.component';
import { AccountsettingsComponent } from './components/account/components/accountsettings/accountsettings.component';
import { AnalyticsComponent } from './components/analytics/analytics.component';
import { DeveloperGuideComponent } from './components/about-us/developer-guide/developer-guide.component';
import { UserGuideComponent } from './components/about-us/user-guide/user-guide.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationBarComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    LoginComponent,
    GamesComponent,
    WishlistComponent,
    WatchlistComponent,
    FriendslistComponent,
    ProfileComponent,
    AccountsettingsComponent,
    AnalyticsComponent,
    DeveloperGuideComponent,
    UserGuideComponent
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
