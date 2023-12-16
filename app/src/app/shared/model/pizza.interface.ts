export interface IPizza {

  id: number;
  menuCategory: string;
  name: string;
  description?: string;
  priceDisplayStr: string;
  isSpecialty: boolean;

  sizeNames: string[];
  prices: number[];
  toppings: string[];
}
