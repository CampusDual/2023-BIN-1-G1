import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-companies-new',
  templateUrl: './companies-new.component.html',
  styleUrls: ['./companies-new.component.css']
})
export class CompaniesNewComponent implements OnInit {


  constructor(
 
  ) { }

  public forceInsertMode(event: any) {
    alert("Buenos dias señora");/*
    if (event != OFormComponent.Mode().INSERT) {
      this.form.setInsertMode();
      this.form.setFieldValues(this.data)
    }*/
  }

  public closeDialog(event: any) {
    alert("Adolf mir");
    /*
    this.dialogRef.close();*/
  }

  ngOnInit() {
  }


}
