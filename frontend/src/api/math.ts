import { api } from './client'

export interface SumResponse {
  result: number
}

export const mathApi = {
  sum: (a: number, b: number) =>
    api.post<SumResponse>('/math/sum', { a, b }),
}
