import { Injectable } from '@angular/core';
import { Response, Headers, RequestOptions, BrowserXhr, ResponseContentType } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class AppService {

  private API_URL: string = 'http://localhost:8008/poc-pdf-service/service-pdf/list_pdf_template';
 
	url(path: string) {
		return this.API_URL + path;
	}
 
	headers() {
		let headersParams = { 'Content-Type': 'application/json' };
		let headers = new Headers(headersParams);
    let options = new RequestOptions({ headers: headers });
    return options;
	}
 
	constructor(private http: Http) {
	}
 
	generatePDF(): any {
		let params = JSON.stringify(
			[{ "nome": "Raphael", "email": "dev.rapha@gmail.com" }]
		);

		return this.http.post(this.API_URL, params, this.headers()).map(
			(response) => {
          return new Blob([response], { type: 'application/pdf' })
        }
		)
	}

}