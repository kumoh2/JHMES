import { useQuery } from '@tanstack/react-query';
import { api } from '../api';
import type { Product } from '../types/product';

export const useProducts = () =>
  useQuery<Product[]>({
    queryKey: ['products'],
    queryFn: async () => {
      const { data } = await api.get<Product[]>('/products');
      return data;
    },
  });
