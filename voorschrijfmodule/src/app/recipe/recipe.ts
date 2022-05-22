import {MedicineOrder} from './medicine-order';

export interface Recipe {
  bsn: String;
  prescriptionDate: Date;
  deliveryMethod: String;
  endDate: Date;
  orders: MedicineOrder[];
}
