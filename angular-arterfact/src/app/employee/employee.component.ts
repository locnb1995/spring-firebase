import { Component, OnInit } from '@angular/core';
import EmployeeService from './employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  data: any;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getEmp().
    then(res => {
      this.data = res;
    }).
    catch(err => console.log(err));
  }

}
