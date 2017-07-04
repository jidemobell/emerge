import { Injectable } from '@angular/core';
import { Http, Headers, URLSearchParams } from '@angular/http';
import { config } from './config';
// import { UserService } from '../services/user.service';

@Injectable()
export class HttpClient {
  constructor(private http: Http) {
    this.http = http;
  }

  createAuthorizationHeader(headers: Headers, extraHeaders: any = {}) {
    for (let i in extraHeaders) {
      headers.append(i, extraHeaders[i]);
    }

    // headers.append('umSessionID', '111');
    // headers.append('umUserHash', '1234ABC');
    // headers.append('umDomain', 'lx-dev-emea-emerge-ui-nx-01');
  }

  createQueryParams(search: Object): URLSearchParams {
    let urlSearchParams: URLSearchParams = new URLSearchParams();
    for (let i in search) {
      urlSearchParams.set(i, search[i]);
    }

    return urlSearchParams;
  }

  get(url: string, params: Object = {}, extraHeaders: any = {}) {
    let headers = new Headers();
    this.createAuthorizationHeader(headers, extraHeaders);
    let search = this.createQueryParams(params);
    return this.http.get(url, {
      headers,
      search
    });
  }

  post(url: string, data, extraHeaders: any = {}) {
    let headers = new Headers();
    this.createAuthorizationHeader(headers, extraHeaders);
    return this.http.post(url, data, {
      headers: headers
    });
  }

  put(url: string, data, extraHeaders: any = {}) {
    let headers = new Headers();
    this.createAuthorizationHeader(headers, extraHeaders);
    return this.http.put(url, data, {
      headers: headers
    });
  }

  delete(url: string, extraHeaders: any = {}) {
    let headers = new Headers();
    this.createAuthorizationHeader(headers, extraHeaders);
    return this.http.delete(url, {
      headers: headers
    });
  }
}
