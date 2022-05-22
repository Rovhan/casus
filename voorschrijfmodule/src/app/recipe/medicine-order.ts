import {Medicine} from '../medicine/medicine';

export interface MedicineOrder {
  medicine: Medicine;
  numberOf: number;
  prescription: String;
}
