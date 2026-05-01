import { useState } from 'react'
import { mathApi } from './api/math'

interface CalcState {
  a: number
  b: number
  result: number | null
  status: 'idle' | 'loading' | 'ok' | 'error'
  error: string | null
}

function App() {
  const [calc, setCalc] = useState<CalcState>({
    a: 0, b: 0, result: null, status: 'idle', error: null,
  })

  const handleSum = async () => {
    const a = Math.floor(Math.random() * 100)
    const b = Math.floor(Math.random() * 100)
    setCalc({ a, b, result: null, status: 'loading', error: null })

    try {
      const data = await mathApi.sum(a, b)
      setCalc(prev => ({ ...prev, result: data.result, status: 'ok' }))
    } catch (e) {
      setCalc(prev => ({
        ...prev,
        status: 'error',
        error: e instanceof Error ? e.message : 'Error desconocido',
      }))
    }
  }

  return (
    <div style={{ padding: '2rem', maxWidth: 480 }}>
      <h1>🌿 Huly</h1>
      <p>Tu jardín de bienestar emocional</p>

      <hr style={{ margin: '1.5rem 0' }} />

      <h2>Prueba de conexión</h2>
      <p style={{ color: '#555', marginBottom: '1rem' }}>
        Genera dos números random, los envía al backend y muestra la suma.
      </p>

      <button
        onClick={handleSum}
        disabled={calc.status === 'loading'}
        style={{ padding: '0.5rem 1.25rem', cursor: 'pointer' }}
      >
        {calc.status === 'loading' ? 'Calculando...' : 'Sumar números random'}
      </button>

      {calc.status !== 'idle' && (
        <div style={{ marginTop: '1rem' }}>
          <p>
            {calc.a} + {calc.b} ={' '}
            {calc.status === 'ok' && <strong>{calc.result}</strong>}
            {calc.status === 'loading' && '...'}
          </p>
          {calc.status === 'error' && (
            <p style={{ color: 'red' }}>Error: {calc.error}</p>
          )}
        </div>
      )}
    </div>
  )
}

export default App
