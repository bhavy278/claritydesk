# ClarityDesk — Architecture

## System Overview
ClarityDesk is a full-stack AI intelligence platform built on
Next.js 14 (frontend) and Spring Boot 3 (backend), using
PostgreSQL + pgvector for data and vector storage, Redis for
caching and alert queuing, and OpenAI GPT-4o for analysis.

## Core Modules

### Ingest Module
Handles Gmail API polling and PDF/DOCX document parsing.
All ingested content is normalized into a unified Source entity.

### AI Module
Runs GPT-4o analysis on ingested content, generates embeddings
via OpenAI text-embedding-3-small, and stores vectors in pgvector.
Handles conflict detection across sources.

### Actions Module
Executes user or AI-triggered actions — Google Calendar events,
reminders via Redis TTL, and email draft creation via Gmail API.

### Alerts Module
Spring Scheduler polls every 15 minutes for upcoming deadlines
and unresolved high-severity insights, pushing alerts via WebSocket.

### Chat Module
RAG-based Q&A using pgvector semantic search + GPT-4o.
Maintains conversation history per user session.

## Data Flow
GMAIL / DOCUMENT → INGEST → PARSE → EMBED → ANALYZE → INSIGHTS → ACTIONS / ALERTS
EOF