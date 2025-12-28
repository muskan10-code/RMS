import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.css']
})
export class CounterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
//this is a variable that hold number
totaltask:number = 0;
//same process
pendingtask:number = 0;
finishedtask:number = 0;

//we have created setinterval function with arrow function and
//and set them in a variable that is projectcountstop.
projectcountstop:any = setInterval(()=>{
  this.totaltask++;
  //we need to stop this at  particular point; will use if condition
  if(this.totaltask ==287)
  {
    //clearinterval will stop tha function
    clearInterval(this.projectcountstop);
  }

},10) //10 is milisecond you can control it


accuratecountstop:any = setInterval(()=>{
  this.pendingtask++;
  if(this.pendingtask == 95)
  {
    
    clearInterval(this.accuratecountstop);
  }
},10) 


clientcountstop:any = setInterval(()=>{
  this.finishedtask++;
  if(this.finishedtask == 300)
  {
    
    clearInterval(this.clientcountstop);
  }
},10)



//conclusion: we have use
//string interpolation
//setInterval function
//()=> arrow function
//clearInterval 
//creating variable


}
