import { createClient } from '@supabase/supabase-js'

const supabaseUrl = 'https://knmqfahxqxfuuyjjoear.supabase.co'
const supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImtubXFmYWh4cXhmdXV5ampvZWFyIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NTE3NTk1MDcsImV4cCI6MTk2NzMzNTUwN30.voLVYJ48FHEBn4Q1H45KTu6H0xLcxI5PwSH142j3C1w'
const supabase = createClient(supabaseUrl, supabaseKey)

export default supabase;