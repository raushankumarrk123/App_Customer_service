import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

const BASIC_URL=["http://localhost:8085/"]

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  postCustomer(customer:any): Observable<any>{
    
  return this.http.post(BASIC_URL+"api/customer",customer);
  }

  getAllCustomers():Observable<any>{
    return this.http.get(BASIC_URL+"api/customers");
  }

  deleteCustomer(id:number): Observable<any>{

    return this.http.delete(BASIC_URL+"api/customer/" +id);
  }

  getCustomerById(id:number):Observable<any>{

    return this.http.get(BASIC_URL+"api/customer/"+id);
  }

  updateCustomer(id:number,customer: any):Observable<any>{

    return this.http.put(BASIC_URL+"api/customer/"+id,customer);
  }
}
