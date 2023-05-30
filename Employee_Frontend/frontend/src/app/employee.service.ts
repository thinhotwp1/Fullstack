import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";
import {Employee} from './employee';

@Injectable({
    providedIn:'root'
})

export class EmployeeService{
    private apiServerUrl = 'http://localhost:8080';

    constructor(private http: HttpClient){}

    public getEmployees(): Observable<Employee[]>{
        return this.http.get<Employee[]>(`${this.apiServerUrl}/get-Employees`)
    }

    public findEmployees(employeeCode:string): Observable<Employee>{
        const params = new HttpParams().set('codeEmployee', employeeCode);
        return this.http.post<Employee>(`${this.apiServerUrl}/find-Employee`, null, { params })
    }

    public addEmployee(employee:Employee): Observable<Employee>{
        return this.http.post<Employee>(`${this.apiServerUrl}/add-Employee`,employee)
    }

    public updateEmployee(employee:Employee): Observable<Boolean>{
        return this.http.post<Boolean>(`${this.apiServerUrl}/update-Employee`,employee)
    }

    public deleteEmployee(employeeCode: string): Observable<boolean> {
        const params = new HttpParams().set('codeEmployee', employeeCode);
        return this.http.post<boolean>(`${this.apiServerUrl}/delete-Employee`, null, { params });
    }
}
