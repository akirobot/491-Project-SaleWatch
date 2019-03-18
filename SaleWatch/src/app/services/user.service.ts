import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root'})
export class UserService {

    uri = 'http://localhost:4000/user';

    constructor(private http: HttpClient) { }

    login(user_email, user_password) {
        const obj = {
            user_email: user_email,
            user_password: user_password
        };
        console.log(obj);
        //we use http.post because it's way more secure than .get... get uses the URL strings where post uses a message body
        this.http.post(`${this.uri}/login`, obj)
            .subscribe(res => console.log('Logged In'));
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
    
}