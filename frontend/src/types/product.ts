export interface Product {
  productId: string;
  productName: string;
  description?: string;
  unit?: string;
  unitConversion?: string;
  specification?: string;
  inspectionType?: string;
  isActive?: boolean;
  createdAt?: string; // ISO date
  updatedAt?: string;
}
