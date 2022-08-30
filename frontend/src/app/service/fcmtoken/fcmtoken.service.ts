import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/fcmtokens';

@Injectable({
  providedIn: 'root'
})
export class FcmtokenService {

  constructor(private http: HttpClient) { }

  public getAllFcmTokensForAccount(accountId:string):Observable<any>{
    const params = new HttpParams().set('accountId',accountId);
    return this.http.get(API_URL+'/all',{params:params});
  }

  public addFcmToken(accountId:string, token:any):Observable<any>{
    const params = new HttpParams().set('accountId',accountId);
    return this.http.post(API_URL+'/add',token,{params:params});
  }
}
