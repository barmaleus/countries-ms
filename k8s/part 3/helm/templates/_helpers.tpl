{{/*
Custom labels
*/}}
{{- define "countries-app.labels" -}}
labels:
  generator: helm
  date: {{ now | htmlDate }}
  version: {{ .Chart.AppVersion | quote }}
{{- end -}}