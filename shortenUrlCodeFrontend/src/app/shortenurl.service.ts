import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShortenurlService {

  localhostUrl = "http://localhost:80";

  constructor(private http: HttpClient) { 
  }

  generateShortUrl(longUrl: string): Observable<any> {
    const headers = {'Authorization': 'Basic dXNlcjoyMzE3NzY='};
    return this.http.post<any>(`${this.localhostUrl}/generateShortUrl`, longUrl, {headers});
  }
}
