import { useState } from 'react'
import './App.css'
import { Button } from './components/ui/button'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <h1 className='text-amber-500'>Tailwind test</h1>
      <Button/>
    </>
  )
}

export default App
