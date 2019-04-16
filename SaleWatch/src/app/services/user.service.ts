import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable, BehaviorSubject } from 'rxjs';

import { User } from '../models/User.js';

@Injectable({ providedIn: 'root'})
export class UserService {

    
    public users: User;
    public currentUser$: Observable<User>;
    private currentUserSubject$: BehaviorSubject<User>;
    public uri = 'http://localhost:4000/user';

    constructor(private http: HttpClient) {
        this.currentUserSubject$ = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser$ = this.currentUserSubject$.asObservable();
     }

     public get currentUserValue(): User {
         return this.currentUserSubject$.value;
     }

    login(user_email, user_password) {
        const obj = {
            user_email: user_email,
            user_password: user_password
        };
        // console.log(obj); testing purpose
        // we use http.post because it's way more secure than .get... get uses the URL strings where post uses a message body
        return this.http.post(`${this.uri}/login`, obj)
            .pipe(map(user => {
                if (user) {
                    this.users = user as User;
                    this.users.forEach(u => {
                        if(u.user_email == obj.user_email && u.user_password == obj.user_password) {
                            localStorage.setItem('currentUser', JSON.stringify(u));
                            this.currentUserSubject$.next(u);
                            console.log("Logged in successful");
                            return u;
                        } 
                    });
                }
            }))
            
    }

    register(user_first_name, user_last_name, user_email, user_password) {
        const obj = {
            user_first_name: user_first_name,
            user_last_name: user_last_name,
            user_email: user_email,
            user_password: user_password
        };
        console.log(obj);
        this.http.post(`${this.uri}/register`, obj)
            .subscribe(res => console.log('Registered'));
    }

    logout() {
        localStorage.removeItem('currentUser');
        this.currentUserSubject$.next(null);
    }
}