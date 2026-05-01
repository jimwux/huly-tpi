const BASE_URL = '/api'

type RequestOptions = Omit<RequestInit, 'body'> & { body?: unknown }

async function request<T>(path: string, options: RequestOptions = {}): Promise<T> {
  const { body, headers, ...rest } = options

  const response = await fetch(`${BASE_URL}${path}`, {
    ...rest,
    headers: {
      'Content-Type': 'application/json',
      ...headers,
    },
    body: body !== undefined ? JSON.stringify(body) : undefined,
  })

  if (!response.ok) {
    throw new Error(`HTTP ${response.status}: ${response.statusText}`)
  }

  return response.json() as Promise<T>
}

export const api = {
  get: <T>(path: string, options?: RequestOptions) =>
    request<T>(path, { ...options, method: 'GET' }),

  post: <T>(path: string, body: unknown, options?: RequestOptions) =>
    request<T>(path, { ...options, method: 'POST', body }),
}
