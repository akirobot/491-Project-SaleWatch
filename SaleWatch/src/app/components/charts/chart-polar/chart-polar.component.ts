import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chart-polar',
  templateUrl: './chart-polar.component.html',
  styleUrls: ['./chart-polar.component.css']
})
export class ChartPolarComponent implements OnInit {
  // PolarArea
  public polarAreaChartLabels: string[] = ['Download Sales', 'In-Store Sales', 'Mail Sales', 'Telesales', 'Corporate Sales'];
  public polarAreaChartData: number[] = [300, 500, 100, 40, 120];
  public polarAreaLegend = true;

  public polarAreaChartType = 'polarArea';

  constructor() { }

  ngOnInit() {
  }

  // events
  public chartClicked(e: any): void {
    console.log(e);
  }

  public chartHovered(e: any): void {
    console.log(e);
  }
}
