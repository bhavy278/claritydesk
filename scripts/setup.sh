#!/bin/bash
echo "🚀 Setting up ClarityDesk local development environment..."

# Copy env file
if [ ! -f .env ]; then
  cp .env.example .env
  echo "✅ Created .env from .env.example — fill in your API keys"
fi

# Start Docker services
echo "🐳 Starting PostgreSQL and Redis..."
docker-compose -f docker/docker-compose.yml up -d

# Wait for PostgreSQL to be ready
echo "⏳ Waiting for PostgreSQL to be ready..."
until docker exec claritydesk_postgres pg_isready -U claritydesk_user; do
  sleep 2
done

echo "✅ ClarityDesk dev environment is ready!"
echo ""
echo "Next steps:"
echo "  1. Fill in your API keys in .env"
echo "  2. cd backend && mvn spring-boot:run"
echo "  3. cd frontend && npm run dev"
EOF

chmod +x scripts/setup.sh