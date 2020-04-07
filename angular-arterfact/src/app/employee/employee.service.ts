import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as Constant from '../constant/AppConstant';

@Injectable()
export default class EmployeeService {
    constructor(private httpClient: HttpClient) { }

    getEmp(): Promise<any> {
        return this.httpClient.get(Constant.GET_EMP).toPromise();
    }
}

