import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Medicine} from './medicine';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private http: HttpClient) { }

  getMedicines(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>('/api/medicine');
  }
}
