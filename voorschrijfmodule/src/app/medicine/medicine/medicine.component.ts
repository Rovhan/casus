import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {Medicine} from '../medicine';
import {MedicineService} from '../medicine.service';

@Component({
  selector: 'app-medicine',
  templateUrl: './medicine.component.html',
  styleUrls: ['./medicine.component.css']
})
export class MedicineComponent implements OnInit {
  medicines: Medicine[] = [];
  displayedColumns: String[] = ['name', 'unit', 'unitsPerPackage', 'unitsInUnit', 'actions']

  constructor(private medicineService: MedicineService) { }

  ngOnInit(): void {
    this.refresh();
  }

  private refresh() {
    this.medicineService.getMedicines().subscribe(medicines => {
      this.medicines = medicines;
    });
  }

  addToRecipe(element: Medicine) {

  }
}
