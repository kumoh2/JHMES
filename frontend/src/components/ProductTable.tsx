import { useProducts } from '../hooks/useProducts';

export default function ProductTable() {
  const { data, isLoading, error } = useProducts();

  if (isLoading) return <p>Loading...</p>;
  if (error) return <p style={{ color: 'red' }}>에러: {(error as Error).message}</p>;

  return (
    <table border={1} cellPadding={4}>
      <thead>
        <tr>
          <th>Code</th>
          <th>Name</th>
          <th>Unit</th>
          <th>Active</th>
        </tr>
      </thead>
      <tbody>
        {data?.map(p => (
          <tr key={p.productId}>
            <td>{p.productId}</td>
            <td>{p.productName}</td>
            <td>{p.unit}</td>
            <td>{p.isActive ? 'Y' : 'N'}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
